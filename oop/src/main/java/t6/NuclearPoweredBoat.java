package t6;

import lombok.Value;
import t7.Annotation;

@SuppressWarnings("WeakerAccess")
@Annotation("NuclearPoweredBoat")
public class NuclearPoweredBoat {
    private String name;
    private Engine engine;

    @Value
    private class Engine {
        private double power;
    }

    @SuppressWarnings("unused")
    public NuclearPoweredBoat(String name, Engine engine) {
        this.engine = engine;
    }

    public NuclearPoweredBoat(String name, double power) {
        Engine engine = new Engine(power);
        this.engine = engine;
    }

    public String swim() {
        return String.format("%s swimming with engine %s", name, engine.toString());
    }

    public static String getValueFromAnnotation() {
        return NuclearPoweredBoat.class
                .getAnnotation(Annotation.class)
                .value();
    }
}
