# Первое задение
## Вся конфигурация находится в 2 файлах
- db.properties для настройки работы с БД и конфигурация пула
- hibernate.properties для установки диалекта и действия hibernate при запуске

# Для создания репозитория нового класса нужно
1. Создать класс и анотировать его как @Entity и задать по умолчанию первичный ключ "long id"
2. Создать интерфейс и репозиторий для работы с этим классом.
3. Унаследовать репозиторий от GenericDaoImpl< имя класса>.
4. Создать пустой конструктор репозитории и вызвать в нём функцию setClas(имя обьекта.class)

# У GenericDaoImpl реализованны следующие функции:
- public T findUniqueBy (String propertyName, Object value); 
- public List<T> findBy (String propertyName, Object value);
- public List<T> getByIds (String IDS);
- public void insert (T entity) ;
- public void update (T entity) ;