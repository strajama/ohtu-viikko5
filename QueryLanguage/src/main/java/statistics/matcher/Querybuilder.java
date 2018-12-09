/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author strajama
 */
public class Querybuilder {

    private Matcher m;

    public Querybuilder() {
        m = new All();
    }

    public Matcher build() {
        return m;
    }

    public Querybuilder playsIn(String team) {
        m = new And(m, new PlaysIn(team));
        return this;
    }

    public Querybuilder hasAtLeast(int value, String category) {
        m = new And(m, new HasAtLeast(value, category));
        return this;
    }

    public Querybuilder hasFewerThan(int value, String category) {
        m = new And(m, new HasFewerThan(value, category));
        return this;
    }
    
    public Querybuilder oneOf(Matcher... matchers) {
        m = new Or(matchers);
        return this;
    }

}
