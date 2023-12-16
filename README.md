# A classic application for coursework
Это приложение позволяет пользователю регистрироваться, авторизоваться, вводить/изменять/удалять информацию о себе, а также просматривать полезную информацию с помощью RecyclerView с последующим отображением в другом Activity. Также здесь реализованы различные анимации.
### Функциональность:
- аутентификация и авторизация пользователей;
- добавление/изменение/удаление информации о пользователе;
- отображение полезной информации с использованием RecyclerView;
- анимации для улучшения пользовательского интерфейса.

Приложение разработано с использованием MVVM, SOLID, DI (Hilt), Room, SQLite. Пытался следовать принципу Single Activity, но получилось отчасти. Этот функционал разрабатывался в команде из 8 человек, большая часть которых впервые делала подобные вещи.

Роль каждого участника команды:
1. 3D-моделлер реализовал несколько моделей, но с анимацией были проблемы. Поэтому ему пришлось сделать ту модель, которая отображается в приложении.
2. Дизайнер и Аниматор реализовал иконку приложения и анимировал 3D модель.
3. Тестировщик тестировал мобильное приложение и сайт, а также разбирался с удобством установки приложения.
4. Разработчик [сайта](https://olimpiaprj.wixsite.com/my-site) создал сайт с помощью Wix.
5. Андроид разработчик решил сделать работу с SQLite. Но было реализовано плоховато. К тому же он заболел и не смог сделать до конца.
6. Андроид разработчик реализовал перевод в runtime.
7. Андроид разработчик взял на себя всю работу (т.е. создание CRUD операций) с базой данных Firebase, но не смог ее выполнить. В конце я дал ему шанс и поручил ему внедрить анимацию в приложение...
8. Андроид разработчик. Изначально я должен был работать только с UI. Из-за того, что 7 не смог справиться со своей задачей, а работа 5 была не завершена. Я решил, что это так не пойдет и все сделал сам.

После разработки приложения я внедрил туда свое первое приложение(Single Activity). Просто для развлечения.

В MFA(my first app) было реализовано то же самое, но без базы данных и mvvm. Когда ее разрабатывал, я не знал, как использовать mvvm и базы данных в андроид. Поэтому оно таким и осталось.
