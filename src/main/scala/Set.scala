package com.Dolzhko_Nazarii.lab_1


import scala.annotation.tailrec
import scala.collection.mutable

enum Set[+A]:
  case Empty
  case NonEmpty private[Set] (a: A, rest: Set[A])

  override def toString: String =
    @tailrec
    def go(sb: StringBuilder, as: Set[A]): String = {
      as match {
        case Empty => sb.append('}').result
        case NonEmpty(a, Empty) => sb.append(a).append('}').result
        case NonEmpty(a, rest) => go(sb.append(a).append(", "), rest)
      }
    }
    go(new StringBuilder("{"), this)

object Set:
  def apply[A](xs: A*): Set[A] = makeSet(xs*)

  def makeSet[A](xs: A*): Set[A] =
    xs.distinct.foldRight(Empty: Set[A])((a, rest) => NonEmpty(a, rest))

  def foldRight[A, B](xs: Set[A], z: B)(f: (A, B) => B): B =
    xs match
      case Empty => z
      case NonEmpty(a, rest) => f(a, foldRight(rest, z)(f))

  def filter[A](xs: Set[A], f: A => Boolean): Set[A] =
    foldRight(xs, Empty: Set[A])((a, rest) => if (f(a)) NonEmpty(a, rest) else rest)

  def zip[A, B](xs: Set[A], ys: Set[B], padXs: A, padYs: B): List[(A, B)] =
    (xs, ys) match
      case (Empty, Empty) => Nil
      case (NonEmpty(a1, rest1), Empty) => (a1, padYs) :: zip(rest1, Empty, padXs, padYs)
      case (Empty, NonEmpty(a2, rest2)) => (padXs, a2) :: zip(Empty, rest2, padXs, padYs)
      case (NonEmpty(a1, rest1), NonEmpty(a2, rest2)) => (a1, a2) :: zip(rest1, rest2, padXs, padYs)

  def unzip[A, B](xs: Set[(A, B)]): (Set[A], Set[B]) =
    def map[A, B](xs: Set[A])(f: A => B): Set[B] =
      foldRight(xs, Empty: Set[B])((a, rest) => NonEmpty(f(a), rest))
    (map(xs)(x => x._1), map(xs)(x => x._2))

  def toList[A](xs: Set[A]): List[A] =
    foldRight(xs, Nil: List[A])((a, tail) => a :: tail)

@main def run(): Unit =
  println("Hello world")