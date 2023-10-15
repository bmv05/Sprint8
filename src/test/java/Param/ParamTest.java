/* Ты пишешь игру про сапёра. Ему предстоит обезвредить бомбу. Для этого нужно перерезать два провода из трёх. Если выбрать провод не того цвета, бомба взорвётся.
Допиши тестовый класс ParamTest: он проверяет, что будет, если ввести разные цвета. Проверь варианты, когда пользователь вводит «красный», «зелёный», «чёрный», «жёлтый».
Класс Bomb для бомбы уже написан — он хранится в отдельной вкладке рядом с заданием.*/


package Param;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParamTest {

    private final String color;
    private final String expectedString;

    public ParamTest(String color, String expectedString) {
        this.color = color;
        this.expectedString = expectedString;
    }

    @Parameterized.Parameters (name = "Тестовые данные: {0} {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"красный","Произошёл взрыв!"},
                {"зелёный","Фух! Осталось обрезать ещё один провод."},
                {"чёрный","Отлично! Бомба почти обезврежена!"},
                {"жёлтый","Ты не можешь обрезать провод, которого нет!"},
        };
    }

    @Test
    public void paramTest() {
        Bomb bomb = new Bomb();
        Assert.assertEquals(expectedString, bomb.cutTheWire(color));
        System.out.println("Аккуратно режь " + color + " провод. " + expectedString);
    }
}
