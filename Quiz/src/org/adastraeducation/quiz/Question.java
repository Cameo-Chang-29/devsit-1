package org.adastraeducation.quiz;
/*
  Question is the base class of all questions.  It is abstract.
  The actual questions are MultiChoice, MultiAnswer, Matching, etc.
  
  The purpose of question is the contain the values shared by all questions, such as id, name and level.

  @author: Dov Kruger
 */
public abstract class Question {
	private String id;      // unique id (for database, maybe XML?)
	private String name;    // displayed above the question
	private int level;      // difficulty level, used for adaptive quiz
	private String question; // text of the question
	private boolean ImgQuestion; // if true, the question string is the name of a picture
	public Question() {}

	public Question(String id, String name, String level, String question) {
		this.id = id;
		this.name = name;
		this.level = Integer.parseInt(level);
				//TODO: trap errors in case level is not a valid integer
		this.question = question;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String q) {
		question = q;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public void writeHTMLHeader(StringBuilder b) {
		b.append("<h1>").append(name).append("</h1>");
		b.append("<h2>" + question + "</h2>");
	}
	protected static void writeAttr(StringBuilder b, String tag, String val) {
		b.append(tag).append("=\"").append(val).append("\" ");
	}
	protected static void writeOptAttr(StringBuilder b, String tag, boolean val) {
		if (val) {
			b.append(tag).append("=\"").append(val).append("\" ");
		}
	}

    /*
      write the three tags id, name and level called by all children
      in both writeHTML and writeXML methods
    */
	protected void writeAttrs(StringBuilder b) {
		writeAttr(b, "id", id);
		writeAttr(b, "name", name);
		writeAttr(b, "level", String.valueOf(level));
	}
	protected void endTagWriteQuestion(StringBuilder b) {
		b.append(">\n").append(question);
	}

	public abstract void writeHTML(StringBuilder b);
	public abstract void writeXML(StringBuilder b);

	// Not ready for this yet...
	//	public abstract void writeDB();
	//  public abstract void readDB();
	// public abstract void readXML()
}
