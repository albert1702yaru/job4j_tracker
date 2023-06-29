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
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
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
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
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