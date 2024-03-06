package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkArrayIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkStringContains() {
        NameLoad nameLoad = new NameLoad();
        String[] str = {"Алексей=Корниенко", "Иван Иванов", "Петр=Перов"};
        assertThatThrownBy(() -> nameLoad.parse(str)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: Иван Иванов does not contain the symbol '='");
    }

    @Test
    void checkStartsWith() {
        NameLoad nameLoad = new NameLoad();
        String[] str = {"Алексей=Корниенко", "=Иван=Иванов", "Петр=Перов"};
        assertThatThrownBy(() -> nameLoad.parse(str)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: =Иван=Иванов does not contain a key");
    }

    @Test
    void checkindexOf() {
        NameLoad nameLoad = new NameLoad();
        String[] str = {"Алексей=Корниенко", "ИванИванов=", "Петр=Перов"};
        assertThatThrownBy(() -> nameLoad.parse(str)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: ИванИванов= does not contain a value");
    }
}