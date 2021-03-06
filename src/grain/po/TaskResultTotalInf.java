package grain.po;

public class TaskResultTotalInf {
	private String student_id;
	private String student_name;
	private String head_logo;
	private int difficulty_level;
	private int total_time;
	private int today_time;
	private float self_score;
	private int duration_day;
	private int total_day;
	private int clock_rank;
	
	public TaskResultTotalInf() {}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getHead_logo() {
		return head_logo;
	}

	public void setHead_logo(String head_logo) {
		this.head_logo = head_logo;
	}

	public int getDifficulty_level() {
		return difficulty_level;
	}

	public void setDifficulty_level(int difficulty_level) {
		this.difficulty_level = difficulty_level;
	}

	public int getTotal_time() {
		return total_time;
	}

	public void setTotal_time(int total_time) {
		this.total_time = total_time;
	}

	public int getToday_time() {
		return today_time;
	}

	public void setToday_time(int today_time) {
		this.today_time = today_time;
	}

	public float getSelf_score() {
		return self_score;
	}

	public void setSelf_score(float self_score) {
		this.self_score = self_score;
	}

	public int getDuration_day() {
        return duration_day;
    }

    public void setDuration_day(int duration_day) {
        this.duration_day = duration_day;
    }

    public int getTotal_day() {
        return total_day;
    }

    public void setTotal_day(int total_day) {
        this.total_day = total_day;
    }

    public int getClock_rank() {
        return clock_rank;
    }

    public void setClock_rank(int clock_rank) {
        this.clock_rank = clock_rank;
    }

    @Override
    public String toString() {
        return "TaskResultTotalInf [student_id=" + student_id + ", student_name=" + student_name + ", head_logo="
                + head_logo + ", difficulty_level=" + difficulty_level + ", total_time=" + total_time + ", today_time="
                + today_time + ", self_score=" + self_score + ", duration_day=" + duration_day + ", total_day="
                + total_day + ", clock_rank=" + clock_rank + "]";
    }
	
}
