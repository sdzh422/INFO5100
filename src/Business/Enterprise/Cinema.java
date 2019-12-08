/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Department.CinemaFoodDepartment;
import Business.Department.CinemaServiceDepartment;
import Business.Department.CinemaTicketDepartment;
import Business.Department.Department;
import Business.Department.DepartmentDirectory;
import Business.Enterprise.Enterprise;
import Business.Test.RandomData;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author sdzh4
 */
public class Cinema extends Enterprise{
    private    ArrayList<WorkRequest> food_test;
    private    ArrayList<WorkRequest> ticket_test;
    private    ArrayList<WorkRequest> movieperformence_test;
    private  Map<Integer,String> movie ;
    private  Map<Integer,String> food ;

    public Cinema(String name, String address,int type) {
        super(name, address,type);
        ArrayList<Department> departmentlist =super.getDepartmentDirectory().getDeparmentList();
        departmentlist.add(new CinemaServiceDepartment());
        departmentlist.add(new CinemaFoodDepartment());
        departmentlist.add(new CinemaTicketDepartment()); 
        MovieTicketTest();
        foodTest();
        RandomData generator = new RandomData();
        generator.addRandomData();
        setMovieperformence_test(generator.getPerformance());
        setFood_test(generator.getFood());
        setTicket_test(generator.getTicket());
    }

    public ArrayList<WorkRequest> getFood_test() {
        return food_test;
    }

    public void setFood_test(ArrayList<WorkRequest> food_test) {
        this.food_test = food_test;
    }

    public ArrayList<WorkRequest> getTicket_test() {
        return ticket_test;
    }

    public void setTicket_test(ArrayList<WorkRequest> ticket_test) {
        this.ticket_test = ticket_test;
    }

    public ArrayList<WorkRequest> getMovieperformence_test() {
        return movieperformence_test;
    }

    public void setMovieperformence_test(ArrayList<WorkRequest> movieperformence_test) {
        this.movieperformence_test = movieperformence_test;
    }

    public Map<Integer, String> getMovie() {
        return movie;
    }

    public void setMovie(Map<Integer, String> movie) {
        this.movie = movie;
    }
    public void MovieTicketTest()
    {
        movie = new HashMap<>();
        movie.put(0, "Fifty Shades Darker");
       movie.put(1, "Resident Evil");
       movie.put(2, "LEGO Batman");
       movie.put(3, "Wolverine 3");
       movie.put(4, "Beauty And The Beast");
       movie.put(5, "Ghost In The Shell");
       movie.put(6, "Fast 8 ");
       movie.put(7, "Guardians of the Galaxy");
       movie.put(8, "Pirates of the Caribbean");
       movie.put(9, "Wonder Woman");
       movie.put(10, "Cars 3 ");
       movie.put(11, "The Book Of Henry");
       movie.put(12, "Transformers");
       movie.put(13, "Smurfs");
       movie.put(14, "Despicable Me 3");
       movie.put(15, "Spider-Man");
       movie.put(16, "Valerian");
       movie.put(17, "Alien");
       movie.put(18, "It");
       movie.put(19, "Saw: Legacy");
    }
    public void foodTest()
    {
        food = new HashMap<>();
        food.put(0, "Popcorn");
       food.put(1, "Soft Drink");
       food.put(2, "Hot Dog");
       food.put(3, "Pizza");
       food.put(4, "Hamburger");
       food.put(5, "Cookies");
    }

    public Map<Integer, String> getFood() {
        return food;
    }

    public void setFood(Map<Integer, String> food) {
        this.food = food;
    }
 
}
