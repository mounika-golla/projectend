package practicepro1;

import java.util.*;

class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Camera {
    String model;
    boolean available;

    public Camera(String model) {
        this.model = model;
        this.available = true;
    }
}

class RentalApplication {
    Map<String, User> users = new HashMap<>();
    Map<String, Camera> cameras = new HashMap<>();
    Map<String, Camera> rentedCameras = new HashMap<>();

    public void registerUser(String username, String password) {
        users.put(username, new User(username, password));
        System.out.println("User registered successfully!");
    }

    public void addCamera(String model) {
        cameras.put(model, new Camera(model));
        System.out.println("Camera added successfully!");
    }

    public void displayAvailableCameras() {
        System.out.println("Available Cameras:");
        for (Map.Entry<String, Camera> entry : cameras.entrySet()) {
            if (entry.getValue().available) {
                System.out.println(entry.getKey() + " - " + entry.getValue().model);
            }
        }
    }

    public void rentCamera(String username, String model) {
        if (cameras.containsKey(model) && cameras.get(model).available) {
            rentedCameras.put(username, cameras.get(model));
            cameras.get(model).available = false;
            System.out.println("Camera rented successfully!");
        } else {
            System.out.println("Camera not available for rent.");
        }
    }

    public void returnCamera(String username) {
        if (rentedCameras.containsKey(username)) {
            Camera returnedCamera = rentedCameras.remove(username);
            returnedCamera.available = true;
            System.out.println("Camera returned successfully!");
        } else {
            System.out.println("No rented cameras found for the user.");
        }
    }
}

public class CameraRental {
    public static void main(String[] args) {
        RentalApplication rentalApp = new RentalApplication();

        rentalApp.registerUser("user1", "password1");
        rentalApp.registerUser("user2", "password2");

        rentalApp.addCamera("Canon EOS R5");
        rentalApp.addCamera("Sony A7 III");

        rentalApp.displayAvailableCameras();

        rentalApp.rentCamera("user1", "Canon EOS R5");

        rentalApp.displayAvailableCameras();

        rentalApp.returnCamera("user1");

        rentalApp.displayAvailableCameras();
    }
}

