package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        Predicate<Integer> predicate = (i) -> (i == 1);
        ListUtils.removeIf(input, predicate);
        assertThat(input).hasSize(1).containsSequence(3);
    }

    @Test
    void whenReplaceIf() {
        input.add(3);
        input.add(4);
        input.add(3);
        Predicate<Integer> predicate = (i) -> (i == 3);
        ListUtils.replaceIf(input, predicate, 5);
        assertThat(input).hasSize(5).containsSequence(1, 5, 5, 4, 5);
    }

    @Test
    void whenRemoveAll() {
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);
        input.add(8);
        ListUtils.removeAll(input,
                List.of(1, 4, 6, 8));
        assertThat(input).containsSequence(3, 5, 7);
    }
}