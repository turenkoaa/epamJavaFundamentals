package t6;

import t7.SomeInfo;

@SuppressWarnings("WeakerAccess")
@SomeInfo("NuclearSubmarine")
public class NuclearSubmarine {
    private String name;
    private Engine engine;

    private class Engine {
        private double power;

        public Engine(double power) {
            this.power = power;
        }

        public double getPower() {
            return power;
        }
    }

    @SuppressWarnings("unused")
    public NuclearSubmarine(String name, Engine engine) {
        this.engine = engine;
    }

    public NuclearSubmarine(String name, double power) {
        Engine engine = new Engine(power);
        this.name = name;
        this.engine = engine;
    }

    public String swim() {
        return String.format("Submarine name: %s\nEngine power: %.0f", name, engine.getPower());
    }

    public static String getValueOfSomeInfo() {
        return NuclearSubmarine.class.getAnnotation(SomeInfo.class).value();
    }
}
