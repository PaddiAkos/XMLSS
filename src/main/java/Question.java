import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlList;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Question {
    private int id;
    private String questionname;
    private String type;
    private List<XMLModel> answers;
    public Question() {}
    public Question(int id, String questionname, List<XMLModel> answers,String type) {
        super();
        this.id = id;
        this.questionname = questionname;
        this.answers = answers;
        this.type = type;
    }
    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getQuestionname() {
        return questionname;
    }
    public void setQuestionname(String questionname) {
        this.questionname = questionname;
    }
    @XmlElement
    public List<XMLModel> getAnswers() {
        return answers;
    }
    public void setAnswers(List<XMLModel> answers) {
        this.answers = answers;
    }

    @XmlElement
    public String getType() {return type;}
    public void setType(String type) {this.type = type; }

}  