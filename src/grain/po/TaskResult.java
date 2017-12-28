package grain.po;

import java.util.Date;

public class TaskResult implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String task_result_id;
	private String student_id;
	private String student_name;
	private String head_logo;
	private String task_id;
	private String task_name;
	private String task_logo;
	private String teacher_id;
	private int practice_time;
	private float self_score;
	private String finish_photo;
	private String comments;
	private Date publish_time;
	private int praise_count;
	private int praise_status;
	private int status;
	private float tch_score;
	private String tch_comment;
	private int clock_rank;
	
	public TaskResult() {}

	public TaskResult(String task_result_id, String student_id, String task_id) {
		this.task_result_id = task_result_id;
		this.student_id = student_id;
		this.task_id = task_id;
	}
	
	public void setBasicInf(int practice_time, float self_score) {
		this.practice_time = practice_time;
		this.self_score = self_score;
	}

	public void setPublishInf(String finish_photo, String comments, int rank) {
		this.finish_photo = finish_photo;
		this.comments = comments;
		this.clock_rank = rank;
	}

	public String getTask_result_id() {
		return task_result_id;
	}
	public void setTask_result_id(String task_result_id) {
		this.task_result_id = task_result_id;
	}
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
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getTask_logo() {
		return task_logo;
	}
	public void setTask_logo(String task_logo) {
		this.task_logo = task_logo;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getPractice_time() {
		return practice_time;
	}
	public void setPractice_time(int practice_time) {
		this.practice_time = practice_time;
	}
	public float getSelf_score() {
		return self_score;
	}
	public void setSelf_score(float self_score) {
		this.self_score = self_score;
	}
	public String getFinish_photo() {
		return finish_photo;
	}
	public void setFinish_photo(String finish_photo) {
		this.finish_photo = finish_photo;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	public int getPraise_count() {
		return praise_count;
	}
	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}
	public int getPraise_status() {
		return praise_status;
	}
	public void setPraise_status(int praise_status) {
		this.praise_status = praise_status;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getTch_score() {
		return tch_score;
	}
	public void setTch_score(float tch_score) {
		this.tch_score = tch_score;
	}
	public String getTch_comment() {
		return tch_comment;
	}
	public void setTch_comment(String tch_comment) {
		this.tch_comment = tch_comment;
	}
	public int getClock_rank() {
        return clock_rank;
    }
    public void setClock_rank(int clock_rank) {
        this.clock_rank = clock_rank;
    }

    @Override
    public String toString() {
        return "TaskResult [task_result_id=" + task_result_id + ", student_id=" + student_id + ", student_name="
                + student_name + ", head_logo=" + head_logo + ", task_id=" + task_id + ", task_name=" + task_name
                + ", task_logo=" + task_logo + ", teacher_id=" + teacher_id + ", practice_time=" + practice_time
                + ", self_score=" + self_score + ", finish_photo=" + finish_photo + ", comments=" + comments
                + ", publish_time=" + publish_time + ", praise_count=" + praise_count + ", praise_status="
                + praise_status + ", status=" + status + ", tch_score=" + tch_score + ", tch_comment=" + tch_comment
                + ", clock_rank=" + clock_rank + "]";
    }
	
}
