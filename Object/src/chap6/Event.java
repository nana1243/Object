package chap6;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;


    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    // private -> public
    public void reschedule(RecurringSchedule schedule){
        from = LocalDateTime.of(from.toLocalDate().plusDays(dayDistance(schedule)),
                schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long dayDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();

    }

    public boolean isSatisfied(RecurringSchedule schedule){

        if (from.getDayOfWeek()!=schedule.getDayOfWeek() ||
        from.toLocalTime().equals(schedule.getFrom()) ||
        duration.equals(schedule.getDuration())){
            // 명령과 쿼리를 분리해야한다.
//            reschedule(schedule);
            return false;
        }
        return true;
    }
}
