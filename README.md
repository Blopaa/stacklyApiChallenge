
# stacklyApiChallenge

<img src="https://team.stacklycode.com/challenges/db.png" />

DB - postgresql

## Auth

#### `/api/user/register`
```json
  {
    "username":"Blopa",
    "email":"Blopaemail",
    "password":"123456"
  }
```

**returns** - JWT token

#### `/api/user/login`
```json
  {
    "email":"Blopaemail",
    "password":"123456"
  }
```

**returns** - JWT token

## Skill

#### `/api/skills/register`
```json
{
  "skillname":  "Java",
  "created_at":  "2020-10-31"
}
```

**returns** - New Skill created

#### `/api/skills/{name}`
```
name {String} - Skill name
```

**returns** - Founded Skill

## Employee

#### `/api/user/skills/{name}`
```
HEADER - JWT token provided in register and login
```
```
name {String} - Skill name
```
**aclaration** - use this to add an skill to an employee

**returns** - String

#### `/api/user/getallusers`

**returns** - All Users
