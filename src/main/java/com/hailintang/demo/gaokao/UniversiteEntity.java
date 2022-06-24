package com.hailintang.demo.gaokao;

public class UniversiteEntity {
    private String name;
    private String year;
    private String rank;
    private String score;
    private String kemu;
    private String pici;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici;
    }

    @Override
    public String toString() {
        return "UniversiteEntity{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", rank='" + rank + '\'' +
                ", score='" + score + '\'' +
                ", kemu='" + kemu + '\'' +
                ", pici='" + pici + '\'' +
                '}';
    }
}
