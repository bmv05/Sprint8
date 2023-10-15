/*Тебе нужно написать автотест для единственного в мире малыша Котопса. Проверь: методы createHalfCat() и createHalfDog() вызываются по одному разу. Используй моки.
Тебе понадобится класс кота, пса и Котопса: они хранятся во вкладках рядом с заданием.

Теперь добавь к тесту стабы. Они должны возвращать половину кота и пса, когда ты вызываешь соотвествующие методы с параметрами:
половина кота — две лапы, говорит: «Я самый умный»;
половина пса — две лапы, говорит: «Я самый весёлый».
Затем проверь, что у Котопса получилось четыре лапы и он говорит: «Единственный в мире малыш Котопёс».
 */

package MocksAndStubs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    private Cat cat;
    @Mock
    private Dog dog;

    @Test
    public void mockTest() {
        cat.createHalfCat();
        dog.createHalfDog();
        Mockito.verify(cat, Mockito.times(1)).createHalfCat(); // проверь, что createHalfCat() вызвался один раз
        Mockito.verify(dog, Mockito.times(1)).createHalfDog(); // проверь, что createHalfDog() вызвался один раз
    }

    @Test
    public void Stubtest() {
        Mockito.when(cat.createHalfCat()).thenReturn( new Cat(2, "Я самый умный"));// стаб, возвращающий половину кота с параметрами - 2 лапы, говорит "Я самый умный"
        Mockito.when(dog.createHalfDog()).thenReturn(new Dog(2, "Я самый весёлый"));// стаб, возвращающий половину пса с параметрами - 2 лапы, говорит "Я самый весёлый"
        Cat halfCat = cat.createHalfCat();
        Dog halfDog = dog.createHalfDog();
        CatDog catDog = new CatDog(halfCat, halfDog);
        Assert.assertEquals(4,catDog.getLegsCount());// проверка, что у Котопса 4 лапы
        Assert.assertEquals("Единственный в мире малыш Котопёс", catDog.getSound());// проверка, что Котопёс говорит "Единственный в мире малыш Котопёс"
    }

}
