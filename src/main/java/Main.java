public class Main {

    public static void main(String[] args){

        UserDAO.createTableUser();
        User user = new User("Petras","Petrovas");
        UserDAO.createNewUser(user);

        CompanyDAO.createTableCompany();
        CompanyDAO.createNewCompany("KazkasUAB");

        CommentDAO.createNewTableComments();
        Comment comment = new Comment(1,1,"10");
        CommentDAO.createNewComment(comment);

    }

}
