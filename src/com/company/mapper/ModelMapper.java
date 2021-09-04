package com.company.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModelMapper<F, T> {

    public T map(F f, Class<T> t) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException {
        T newObj = t.newInstance();
        for (Field fieldT : t.getDeclaredFields()) {
            fieldT.setAccessible(true);
            for (Field fieldF : f.getClass().getDeclaredFields()) {
                fieldF.setAccessible(true);

                // Перевірка чи поле містить Nested клас
                if (fieldF.getType().isMemberClass()) {
                    // Прохід по методах Nested класу
                    for (Method method : fieldF.get(f).getClass().getDeclaredMethods()) {
                        method.setAccessible(true);
                        String methodName = method.getName().toLowerCase();
                        if (methodName.contains("get") && methodName.contains(getFiledName(fieldT)) && (fieldT.getType() == method.getReturnType())) {
                            fieldT.set(newObj, method.invoke(fieldF.get(f)));
                        }
                    }
                }

                // Якщо поле DTO-класу містить в собі поле об'єкта
                if (getFiledName(fieldT).contains(getFiledName(fieldF)) && fieldF.getType() == fieldT.getType()) {
                    // Перевірка на анотацію MinValue
                    if (fieldF.isAnnotationPresent(MinVal.class)) {
                        int minValue = fieldF.getAnnotation(MinVal.class).min();
                        if (minValue <= (int) fieldF.get(f)) {
                            fieldT.set(newObj, fieldF.get(f));
                        } else {
                            throw new IllegalArgumentException(fieldF.toGenericString() + " should be >= " + minValue);
                        }
                    } else {
                        fieldT.set(newObj, fieldF.get(f));
                    }
                }

                if (getFiledName(fieldT).contains("transplantation")) {
                    if (fieldF.isAnnotationPresent(Transplantation.class) && fieldT.getType() == String[].class) {
                        fieldT.set(newObj, fieldF.getAnnotation(Transplantation.class).transplantations());
                    }
                }

            }
        }
        return t.cast(newObj);
    }

    public String getFiledName(Field field) {
        return field.getName().toLowerCase();
    }
}
