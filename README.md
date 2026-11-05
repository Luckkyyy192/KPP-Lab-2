# Лабораторна робота №2. Варіант 8 — Каталог музейної колекції

**Предметна область:** `User` — музейний куратор або каталогізатор; `Project` — робота з каталогізації колекції, власник `owner`; `Task` — опис конкретної групи експонатів, що належить проєкту. `CompletionPolicy` — контракт допуску завершення; `VariantPolicy` — правило варіанта 8.

**Структура:** `User (owner) <- Project <- Task -> CompletionPolicy <- VariantPolicy`, окремо `Task -> User (assignee)`.

**Незмінні поля:** `User.id/name`, `Project.id/title/owner`, `Task.id/title/project/created/due/policy`; **змінні:** `Task.status`, `Task.assignee` (лише у NEW).

**Стани:** `NEW --[assign; start]--> ACTIVE --[complete, policy=true]--> DONE`. Будь-яка відмова залишає стан без змін. Повторне призначення у NEW дозволене. Завершення після строку допустиме.

**Правило:** `units >= 12 && defects <= units / 4`; `approved` на результат не впливає. Безпечне від переповнення int, оскільки не множить defects на 4.

## Встановлення і запуск

Запустіть `INSTALL_FROM_GITHUB.ps1` у корені комплекту: скрипт підтягує без змін захищені файли, оригінальні тести, Maven Wrapper і `pom.xml` із GitHub. Потрібна JDK 25.

```powershell
cd 'Lab Assignment 2'
.\mvnw.cmd clean verify
java -cp target/classes ua.khnu.kpp.App
```

Очікуваний демонстраційний перехід: `NEW`, `ACTIVE`, відмова з `ACTIVE`, успішно `DONE`. Очікування оригінальної методички: 14 успішних тестів, 0 пропусків, після фактичного запуску.

**Важливо:** `DomainTest.java`, `CounterTest.java`, `cases.csv`, `Status.java`, `CompletionPolicy.java`, `Counter.java`, `.mvn/`, `mvnw*`, `pom.xml` та `.gitignore` заборонено змінювати. Коміт `lab-2` і його SHA формуються лише після реального Git-пушу.
