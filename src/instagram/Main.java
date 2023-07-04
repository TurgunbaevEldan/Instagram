package instagram;

import instagram.db.Database;
import instagram.enums.Gender;
import instagram.model.User;
import instagram.service.serviceImpl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();
        UserServiceImpl userService = new UserServiceImpl(database);
        //        1. Instagram программасын тузунуз
        //        2. 5 жаны пакет тузунуз - model, service, database, enums, exception.
        //        3. enum Gender (MALE,FEMALE) database package-ке DataBase класс болот, полеси kaтaры List<User> users;
        //        4. User деген класс болсун. Свойствалары: (nickName, password, age, photo, Gender gender)
        //        UserService interface болот, жана UserServiceImpl класс UserService interfaceti
        //        implements кылып, полеси katary DataBase классты алат.
        //        5. Методтор:- String addNewUser(User user) //добавить новый user- User
        //        userUpdateById(Long id,String nickName,String password,String photo) //изменить
        //        name, password, и photo- User searchByName(String nickName)// искать по name-
        //        User sortByAge(asc,desc) stream//сортировка по возрасту (по возрастанию и
        //        убыванию)- User filter(asc desc по age) stream //фильтрация по age(например
        //        старше >20 лет или младше <20 лет)


        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    System.out.println(userService.addNewUser(new User(1L, "ELdanTurgumbaev", "el123", 18, "Zima", Gender.MALE)));
                    System.out.println(userService.addNewUser(new User(2L, "Erik", "er123", 14, "leto", Gender.MALE)));
                    System.out.println(userService.addNewUser(new User(3L, "Aizat", "ai123", 20, "osen", Gender.FEMALE)));
                    break;
                case 2:
                    System.out.println(userService.getAllUsers());
                    break;
                case 3:
                    userService.userUpdateById(1L, "ELdan", "el123", "eldan");
                    break;
                case 4:
                    System.out.println(userService.searchByName("Eldan"));
                    break;
                case 5:
                    System.out.println(userService.sortByAge());
                case 6:
                    System.out.println(userService.filter(18));
            }

        }
    }
}