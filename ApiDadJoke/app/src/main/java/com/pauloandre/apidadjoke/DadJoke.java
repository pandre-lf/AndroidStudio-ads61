package com.pauloandre.apidadjoke;

public class DadJoke {
    // https://icanhazdadjoke.com/
    private String joke;
    private String jokeId;
    private String jokeStatus;

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getJokeId() {
        return jokeId;
    }

    public void setJokeId(String jokeId) {
        this.jokeId = jokeId;
    }

    public String getJokeStatus() {
        return jokeStatus;
    }

    public void setJokeStatus(String jokeStatus) {
        this.jokeStatus = jokeStatus;
    }
}
