package com.lld.bookmyshow.services;

import com.lld.bookmyshow.models.Booking;
import com.lld.bookmyshow.models.User;
import com.lld.bookmyshow.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    @Autowired
    BookingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional(Isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, List<Long> seatId, Long showId) {
        Optional<User> userOptional= userRepository.findById(userId);

        // 1. Get the user from userId
        // 2. Get the show with showId
        //  ------ Take lock ---------- (start transaction)
        // 3. Get the showSeat using seatIds
        // 4. Check if all the seats are available
        // 5. If no, throw error
        // 6. If yes, mark all the selected seats are BLOCKED
        // 7. Save it in the database
        // ---------- release the lock : end transaction --------
        // 8. Create the corresponding Booking object
        // 9. Save the booking details in the
        // database
        // 10. Return the booking object

        return null;
    }
}
