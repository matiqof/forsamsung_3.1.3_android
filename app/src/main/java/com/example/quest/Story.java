package com.example.quest;

public class Story {

    private Situation start_story;
    public Situation current_situation;

    Story() {
        start_story = new Situation(
                "первая сделка (Windows)",
                "Только вы начали работать и тут же удача! Вы нашли клиента и продаете ему "
                        + "партию ПО MS Windows. Ему в принципе достаточно взять 100 коробок версии HOME.\n"
                        + "(1)у клиента денег много, а у меня нет - вы выпишете ему счет на 120 коробок ULTIMATE по 50тр\n"
                        + "(2)чуть дороже сделаем, кто там заметит - вы выпишете ему счет на 100 коробок PRO по 10тр\n"
                        + "(3)как надо так и сделаем - вы выпишете ему счет на 100 коробок HOME по 5тр ",
                3, 0, 0, 0);
        start_story.direction[0] = new Situation(
                "Успешно",
                "Ваша первая успешная сделка, но вы не знаете, что же делать дальше. Но у вас есть варианты.\n"
                +"(1)что-то новое - вас не устраивает положение и вы пытаетесь вписаться к главам компании\n"
                +"(2)мелкая кража - вы решаете украсть пару копий систем для себя и близких, а также для продаж на чёрных рынках\n"
                +"(3)очень скучно - вы предлагаете вашему отделу провести какое-нибудь мероприятие",
                3, 0, -10, -10);
        start_story.direction[0].direction[0] = new Situation(
                "Высшая лига",
                "вы подружились с одним из помощников босса и он часто вас прикрывает и восхваляет вас пред начальством.",
                0, 1, 5, 50);
        start_story.direction[0].direction[1] = new Situation(
                "Начинаете с малого",
                "вы провернули вашу сделку и все прошло успешно, пока никто не заметил, но это до поры до времени.",
                0, 0, 100, 0);
        start_story.direction[0].direction[2] = new Situation(
                "Корпоратив",
                "вашу идею приняли с теплом, вот вы собрались в ресторане и провели интересный день, всем очень понравилось.",
                0, 0, -1, 50);
        start_story.direction[1] = new Situation(
                "совещание, босс доволен",
                "Вы пришли на совещание, где вас хвалили всё время, после мероприятия вам позвонили один из помощников и предлагает вам провернуть дело и поднять капиталы компании.\n"
                +"(1)не размышляя - вы соглашаетесь провернуть дело вместе с каким-то торговцем украденных технологий\n"
                +"(2)странные действия - вы соглашаетесь, но при сделке вы крадёте технологии и затем продаёте их по ещё большей цене\n"
                +"(3)как обычно - вы не соглашаетесь и остаётесь спокойно работать в компании",
                3, 1, 100, 0);
        start_story.direction[1].direction[0] = new Situation(
                "Всё так и вышло",
                "ваша компания разбогатела производя операционные системы при помощи тех технологий, а вас повысили.",
                0, 1, 10, 25);
        start_story.direction[1].direction[1] = new Situation(
                "Жизнь в шоколаде",
                "вы разбогатели, но вы больше не работает в компании, а вам это и не надо.",
                0, -100, 10000000, -100);
        start_story.direction[1].direction[2] = new Situation(
                "Ничего не изменилось",
                "вы продолжили работать, как будто ничего не случилось.",
                0, 0, 0, 0);
        start_story.direction[2] = new Situation(
                "большая сделка",
                "Ну вот и настола то, что мне обещал директор по телефону, вам нужно продать целый отдел по производству операционных систем Windows, какому-то миллиардеру.\n"
                        + "(1) обогатить компанию - вы решаете продать часть отдела, схитрив, и получив сумму за полный отдел\n"
                        + "(2) положить себе в карман - вы решаете повысить цену на отдел и ваш покупатель соглашаеться\n"
                        + "(3) поступить по совести - вы как надо продаёте отдел, за ту цену, которая была изначально",
                3, 0, 0, 0);
        start_story.direction[2].direction[0] = new Situation(
                "Хорошая компания",
                "Вы обогатили компанию, начальство осталось доволно вами и повысило вас.",
                0, 1, 100, 50);
        start_story.direction[2].direction[1] = new Situation(
                "Крупный обман",
                "Босс узнал об обмане, вас уволили, вы потеряли всё.",
                0, -1, -100, -50);
        start_story.direction[2].direction[2] = new Situation(
                "Как обычно",
                "Вы совершили сделку как обычно и продолжили работать.",
                0, 0, 0, 10);

        current_situation = start_story;
    }

    public void go(int num) {
        System.out.println(1);
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
