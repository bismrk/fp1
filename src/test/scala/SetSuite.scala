package com.Dolzhko_Nazarii.lab_1


import munit.FunSuite
import Set.*

class SetSuite extends FunSuite {
  test("makeSet 1") {
    val expected = Empty
    val actual = makeSet()
    assertEquals(actual, expected)
  }
  test("makeSet 2") {
    val expected = makeSet(1, 2, 3)
    val actual = makeSet(1, 2, 3, 2, 1)
    assertEquals(actual, expected)
  }
  test("makeSet 3") {
    val expected = makeSet(1, 2, 3)
    val actual = makeSet(1, 1, 2, 2, 3, 3)
    assertEquals(actual, expected)
  }
  test("filter 1") {
    val expected = Empty
    val actual = filter(Empty, _ => true)
    assertEquals(actual, expected)
  }
  test("filter 2") {
    val expected = Set(1, 2, 3)
    val actual = filter(Set(1, 2, 3), _ => true)
    assertEquals(actual, expected)
  }
  test("filter 3") {
    val expected = Empty
    val actual = filter(Set(1, 2, 3), _ => false)
    assertEquals(actual, expected)
  }
  test("filter 4") {
    val expected = Set(1, 3, 5)
    val actual = filter(Set(1, 2, 3, 4, 5), x => x%2 == 1)
    assertEquals(actual, expected)
  }
  test("filter 5") {
    val expected = Set(Array.range(1, 100, 2)*)
    val actual = filter(Set(Array.range(1, 100)*), x => x%2 == 1)
    assertEquals(actual, expected)
  }
  test("zip 1") {
    val expected = Nil
    val actual = zip(Empty, Empty, 0, 0)
    assertEquals(actual, expected)
  }
  test("zip 2") {
    val expected = List((1, 'a'), (2, 'b'), (3, 'c'), (4, '0'), (5, '0'))
    val actual = zip(Set(1, 2, 3, 4, 5), Set('a', 'b', 'c'), 0, '0')
    assertEquals(actual, expected)
  }
  test("zip 3") {
    val expected = List((1, 'a'), (2, 'b'), (3, 'c'), (0, 'd'), (0, 'e'))
    val actual = zip(Set(1, 2, 3), Set('a', 'b', 'c', 'd', 'e'), 0, '0')
    assertEquals(actual, expected)
  }
  test("zip 4") {
    val expected = List((1, 'a'), (2, 'b'), (3, 'c'))
    val actual = zip(Set(1, 2, 3), Set('a', 'b', 'c'), 0, '0')
    assertEquals(actual, expected)
  }
  test("zip 5") {
    val expected = List((1, '0'), (2, '0'), (3, '0'))
    val actual = zip(Set(1, 2, 3), Empty, 0, '0')
    assertEquals(actual, expected)
  }
  test("zip 6") {
    val expected = List((0, 'a'), (0, 'b'), (0, 'c'))
    val actual = zip(Empty, Set('a', 'b', 'c'), 0, '0')
    assertEquals(actual, expected)
  }
  test("unzip 1") {
    val expected = (Empty, Empty)
    val actual = unzip(Empty)
    assertEquals(actual, expected)
  }
  test("unzip 2") {
    val expected = (Set(1, 2, 3), Set('a', 'b', 'c'))
    val actual = unzip(Set((1, 'a'), (2, 'b'), (3, 'c')))
    assertEquals(actual, expected)
  }
  test("toList 1") {
    val expected = Nil
    val actual = toList(Empty)
    assertEquals(actual, expected)
  }
  test("toList 2") {
    val expected = List(1, 2, 3)
    val actual = toList(Set(1, 2, 3))
    assertEquals(actual, expected)
  }
}
