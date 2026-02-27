
import java.util.ArrayList;
import java.util.Scanner;

//main driver
public class Assignment3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<WeatherEvent> events = new ArrayList<>();

        int option = 0;
        System.out.println("[Weather Tracking System]");

        while(option != 5) {
            System.out.println("1. Add weather events");
            System.out.println("2. Update location");
            System.out.println("3. Update active");
            System.out.println("4. View all events");
            System.out.println("5. Quit");
            System.out.print("Enter your option: ");
            option = input.nextInt();

            switch(option) {
                case 1:
                    System.out.println("\n1. Rain");
                    System.out.println("2. Snow");
                    System.out.println("3. Fog");
                    System.out.println("4. Particle");
                    System.out.print("What type of weather event is being added? ");
                    int weatherType = input.nextInt();

                    input.nextLine();
                    System.out.print("Where is the event happening? ");
                    String weatherLocation = input.nextLine();

                    switch(weatherType) {
                        case 1:
                            System.out.print("What is the rate of the fall? (in/h) ");
                            double rainRate = input.nextDouble();
                            System.out.print("What is the diameter of the drops? (in) ");
                            double dropSize = input.nextDouble();

                            events.add(new Rain(weatherLocation, true, rainRate, dropSize));
                            System.out.println("Rain event added");
                            break;
                        case 2:
                            System.out.print("What is the rate of the fall? (in/h) ");
                            double snowRate = input.nextDouble();
                            System.out.print("What is the temperature? (F) ");
                            double temp = input.nextDouble();

                            events.add(new Snow(weatherLocation, true, snowRate, temp));
                            System.out.println("Snow event added");
                            break;  
                        case 3:
                            System.out.print("What is the visibility? (1/8 mi) ");
                            int visibility = input.nextInt();
                            System.out.print("Is the fog freezing? (y/n) ");
                            input.nextLine();
                            String freezing = input.nextLine();

                            boolean isFreezing = freezing.equalsIgnoreCase("y");

                            events.add(new Fog(weatherLocation, true, visibility, isFreezing));
                            System.out.println("Fog event added");
                            break;
                        case 4:
                            System.out.print("What is the visibility? (1/8 mi) ");
                            int partVisibility = input.nextInt();
                            System.out.print("What is the obstruction made of? (Sand/Dust/Ash/Other) ");
                            input.nextLine();
                            String partType = input.nextLine();

                            events.add(new Particle(weatherLocation, true, partVisibility, partType));
                            System.out.println("Particle event added");
                            break;
                        default:
                            System.out.println("Invalid weather type!");
                    }
                    break;
                case 2:
                    System.out.print("Enter id of weather events: ");
                    int locationId = input.nextInt();
                    input.nextLine();

                    WeatherEvent foundLocation = findById(events, locationId);

                    if (foundLocation == null) {
                        System.out.println("No events with that id.");
                    } else {
                        System.out.println("Enter the new location of the weather events (currently \"" + foundLocation.getLocation() + "\"):");
                        String newLocation = input.nextLine();
                        foundLocation.setLocation(newLocation);
                        System.out.println("Location updated");
                    }
                    break;
                case 3:
                    System.out.print("Enter id of weather events: ");
                    int activeId = input.nextInt();

                    WeatherEvent foundActive = findById(events, activeId);

                    if (foundActive == null) {
                        System.out.println("No events with that id.");
                    } else {
                        foundActive.setActive(!foundActive.isActive());
                        System.out.println("Event set to \"" + (foundActive.isActive() ? "active" : "inactive") + "\"");
                    }
                    break;
                case 4:
                    for (WeatherEvent e : events) {
                        System.out.println(e);
                    }
                    break;
                case 5: 
                    System.out.println("Shutting off...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
            System.out.println();
        }
        input.close();
    }
    private static WeatherEvent findById(ArrayList<WeatherEvent> list, int id) {
        for (WeatherEvent e : list) {
            if(e.getId() == id)
                return e;
        }
        return null;
    }
}

// classes
class WeatherEvent {
    private String weatherLocation;
    private static int nextId = 0;
    private int id;
    private boolean active;

    public WeatherEvent(String weatherLocation, boolean active) {
        this.id = nextId++;
        this.weatherLocation = weatherLocation;
        this.active = active;
    }
    public String getLocation() {
        return weatherLocation;
    }
    public int getId() {
        return id;
    }
    public boolean isActive() {
        return active;
    }
    public void setLocation(String weatherLocation) {
        this.weatherLocation = weatherLocation;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "\nWeather Event Location: " + weatherLocation + "\nid: " + id + "\nActive: " + active; 
    }
}

class Precipitation extends WeatherEvent {
    private double rateOfFall;

    public Precipitation(String weatherLocation, boolean active, double rateOfFall) {
        super(weatherLocation, active);
        setRateOfFall(rateOfFall);
    }
    public double getRateOfFall() {
        return rateOfFall;
    }
    public void setRateOfFall(double rateOfFall) {
        this.rateOfFall = Math.max(0, rateOfFall);
    }

    protected String classifyRate() {
        if (rateOfFall < 0.5) return "Light";
        if (rateOfFall <= 1.5) return "Medium";
        return "Heavy";
    }
    @Override
    public String toString() {
        return super.toString() + String.format("\nRate of fall: %.2f in/h (%s)", rateOfFall, classifyRate());
    }
}

class Obstruction extends WeatherEvent {
    private int visibility;

    public Obstruction(String weatherLocation, boolean active, int visibility) {
        super(weatherLocation, active);
        setVisibility(visibility);
    }
    public int getVisibility() {
        return visibility;
    }
    public void setVisibility(int visibility) {
        this.visibility = Math.max(0, visibility);
    }
    @Override
    public String toString() {
        if (visibility >= 56)
            return super.toString() + "\nVisibility: Normal";
        else 
            return super.toString() + "\nVisibility: " + visibility + "/8 mi";
    }
}

class Rain extends Precipitation {
    private double dropSize;

    public Rain(String weatherLocation, boolean active, double rateOfFall, double dropSize) {
        super(weatherLocation, active, rateOfFall);
        setDropSize(dropSize);
    }
    public double getDropSize() {
        return dropSize;
    }
    public void setDropSize(double dropSize) {
        this.dropSize = (dropSize < 0.02) ? 0.02 : dropSize;
    }
    private String classifyDrop() {
        if (dropSize < 0.066) return "Small";
        if (dropSize <= 0.112) return "Medium";
        return "Large";
    }
    @Override
    public String toString() {
        return super.toString() + String.format("\nDrop size: %.2f (%s)", dropSize, classifyDrop());
    }
}

class Snow extends Precipitation {
    private double temperature;

    public Snow(String weatherLocation, boolean active, double rateOfFall, double temperature) {
        super(weatherLocation, active, rateOfFall);
        setTemperature(temperature);
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        if (temperature < -459.67) temperature = -459.67;
        if (temperature > 32) temperature = 32;
        this.temperature = temperature;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("\nTemperature: %.2f F", temperature);
    }
}

class Fog extends Obstruction {
    private boolean freezingFog;

    public Fog(String weatherLocation, boolean active, int visibility, boolean freezingFog) {
        super(weatherLocation, active, visibility);
        setVisibility(visibility);
        this.freezingFog = freezingFog;
    }
    public boolean isFreezingFog() {
        return freezingFog; 
    }
    public void setFreezingFog(boolean freezingFog) {
        this.freezingFog = freezingFog;
    }
    @Override
    public void setVisibility(int visibility) {
        if (visibility < 1) visibility = 1;
        if (visibility > 4) visibility = 4;
        super.setVisibility(visibility);
    }
    @Override
    public String toString() {
        String base = super.toString();
        if (freezingFog)
            return base + "\nALERT! FREEZING FOG!";
        return base;
    }
}

class Particle extends Obstruction {
    private String particleType;

    public Particle(String weatherLocation, boolean active, int visibility, String particleType) {
        super(weatherLocation, active, visibility);
        setParticleType(particleType);
    }
    public String getParticleType() {
        return particleType;
    }
    public void setParticleType(String particleType) {
        if (particleType.equalsIgnoreCase("Dust") || particleType.equalsIgnoreCase("Sand") || particleType.equalsIgnoreCase("Ash")) this.particleType = capitalize(particleType);
        else 
            this.particleType = "Other";
    }

    private String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
    @Override
    public String toString() {
        return super.toString() + "\nParticle type: " + particleType;
    }
}