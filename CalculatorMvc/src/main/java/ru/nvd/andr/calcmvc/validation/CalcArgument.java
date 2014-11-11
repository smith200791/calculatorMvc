package ru.nvd.andr.calcmvc.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


//Прежде всего, обратите внимание на аннотацию @Constraint, которая указывает на то, 
//что @CalcArgument является Constraint аннотацией, также она содержит в себе имя валидатора, 
//который будет использоваться для валидации поля, помеченного как @CouponCode. 
//В нашем случае валидирующий класс - это CalcArgumentValidator. 
//Из других частей аннотации также следует обратить внимание на параметр message,
//который содержит сообщение-ошибку, которое будет передано на клиент, в случае если валидация
//поля прошла не успешно. Также аннотация @Target содержит список элементов Java класса,
//перед которыми мы сможем использовать @CalcArgument.

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {CalcArgumentValidator.class})
public @interface CalcArgument {
    String message() default "Sorry, parameter is illegal, please enter a valid number in";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };
}
