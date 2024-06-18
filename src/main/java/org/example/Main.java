package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    //動画で紹介されたものを一通り実装
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    numbers.stream().filter(number -> number <= 5)
        .forEach(System.out::println);

    numbers.stream()
        .limit(3)
        .forEach(System.out::println);

    List<String> studentList = List.of("taro", "jiro", "saburo", "jiro", "yoshiro", "goro",
        "saburo");
    studentList.stream()
        .map(String::toUpperCase)
        .sorted()
        .distinct()
        .forEach(System.out::println);

    System.out.println(studentList.stream()
        .distinct()
        .collect(Collectors.joining(",")));

    System.out.println(studentList.stream()
        .distinct()
        .anyMatch(v -> v.startsWith("s")));

    System.out.println(studentList.stream()
        .distinct()
        .allMatch(v -> v.startsWith("a")));

    System.out.println(studentList.stream()
        .map(String::toUpperCase)
        .filter(v -> v.startsWith("J"))
        .findFirst());

    //文字列のリストを作成（要素数は10個）
    //その文字列に対して、文字数が２以上のものを抽出して、文字列に変換。区切り文字はカンマ（,）で行う。
    //その文字列を出力
    List<String> comedianList = List.of("seiya", "sosina", "asei", "k", "hicorohi", "i",
        "w", "kasuga", "shitara", "h");
    System.out.println(comedianList.stream()
        .filter(v -> v.length() >= 2)
        .collect(Collectors.joining(",")));

    //数値のリストを作成（要素数は10個）
    //その数値の中の奇数のものだけを抽出して、平均値を算出
    //その平均値を出力
    List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int sum = numberList.stream()
        .filter(v -> v % 2 != 0)
        .mapToInt(Integer::intValue)
        .sum();

    long count = numberList.stream()
        .filter(number -> number % 2 != 0)
        .count();

    if (count > 0) {
      double average = sum / count;
      System.out.println("奇数の平均値は「" + average + "」です");
    } else {
      System.out.println("リストに奇数がありません");
    }

    //ChatGPTなどの生成AIを使って、Stream APIの基礎的な課題を一つ作ってもらい、それを実装
    //「ChatGPTの課題：リスト内の文字列を大文字に変換し、長さ順にソートする」
    //1.文字列のリストを作成してください。リストには10個の任意の文字列を含めます。
    //2.このリスト内の全ての文字列を大文字に変換してください。
    //3.大文字に変換された文字列を、文字列の長さ順に昇順でソートしてください。
    //4.ソートされた文字列リストを出力してください。
    List<String> sweetsList = List.of("ghana", "toppo", "pocky", "kinokonoyama", "takenokonosato",
        "chocopie", "sakusakupanda", "galbo", "aporo", "angelpie");
    System.out.println(sweetsList.stream()
        .map(String::toUpperCase)
        .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
        .collect(Collectors.toList()));
  }
}