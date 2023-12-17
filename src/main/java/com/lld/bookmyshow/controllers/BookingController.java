package com.lld.bookmyshow.controllers;
import com.lld.bookmyshow.dto.BookMovieRequestDTO;
import com.lld.bookmyshow.dto.BookMovieResponseDTO;
import com.lld.bookmyshow.dto.ResponseStatus;
import com.lld.bookmyshow.models.Booking;
import com.lld.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Controller
//@Service
//@Repository
public class BookingController {
    private final BookingService bookingService;
    @Autowired // Automatically find the object in the params,
            // create it if not already created and pass it over
    BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO bookMovieRequestDTO) {
        BookMovieResponseDTO bookMovieResponseDTO = new BookMovieResponseDTO();
        try {
            Booking booking = bookingService.bookMovie(bookMovieRequestDTO.getUserId(), bookMovieRequestDTO.getShowSeatIds(), bookMovieRequestDTO.getShowId());
            bookMovieResponseDTO.setBookingId(booking.getId());
            bookMovieResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            bookMovieResponseDTO.setAmount(booking.getAmount());
        } catch (Exception exception) {
            bookMovieResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return null;
    }
}
