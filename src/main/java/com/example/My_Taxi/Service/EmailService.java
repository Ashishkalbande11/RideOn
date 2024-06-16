package com.example.My_Taxi.Service;

import com.example.My_Taxi.Model.TripBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendMail(TripBooking tripBooking){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String subject = "Cab Booking Confirmation";
        String body = "Dear "+tripBooking.getCustomer().getFirstName()+" "+
                tripBooking.getCustomer().getLastName()+",\n\n "+
                "Your cab booking is confirmed at "+ tripBooking.getJourneyDate()+"\n"+
                "Booking ID: "+tripBooking.getBookingId()+"\n"+"Source: "+
                tripBooking.getSource()+"\n"+"Destination: "+ tripBooking.getDestination()+"\n"+
                "Fare: "+tripBooking.getTotalFare()+"\n\n"+
                "Driver Details: \n"+
                "Name: "+tripBooking.getDriver().getFirstName()+" "+tripBooking.getDriver().getLastName()+"\n"+
                "Contact no.: "+tripBooking.getDriver().getNumber()+
                "Rating: "+tripBooking.getDriver().getRating()+"\n\n"+
                "Thank you for choosing our service !";

        simpleMailMessage.setFrom("ashishkalbande027@gmail.com");
        simpleMailMessage.setTo(tripBooking.getCustomer().getEmail(),tripBooking.getDriver().getEmail());
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);

        javaMailSender.send(simpleMailMessage);
    }
}
