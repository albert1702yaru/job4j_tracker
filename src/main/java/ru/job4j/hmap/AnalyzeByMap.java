package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double balls = 0;
        int items = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                balls += subject.score();
                items++;
            }
        }
        return balls / items;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double balls = 0;
            int items = 0;
            for (Subject subject : pupil.subjects()) {
                balls += subject.score();
                items++;
            }
            list.add(new Label(pupil.name(), balls / items));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        int items = 1;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (map.containsKey(subject.name())) {
                    map.put(subject.name(), map.get(subject.name()) + subject.score());
                } else {
                    map.put(subject.name(), subject.score() / items);
                }
            }
            items++;
        }
        for (String i : map.keySet()) {
            list.add(new Label(i, map.get(i) / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double balls = 0;
            for (Subject subject : pupil.subjects()) {
                balls += subject.score();
            }
            list.add(new Label(pupil.name(), balls));
        }
        Label score = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            score = list.get(i).compareTo(score) > 0 ? list.get(i) : score;
        }
        return score;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (map.containsKey(subject.name())) {
                    map.put(subject.name(), map.get(subject.name()) + subject.score());
                } else {
                    map.put(subject.name(), subject.score());
                }
            }
        }
        for (String i : map.keySet()) {
            list.add(new Label(i, map.get(i)));
        }
        Label score = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            score = list.get(i).compareTo(score) > 0 ? list.get(i) : score;
        }
        return score;
    }
}