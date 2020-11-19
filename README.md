
# stacklyApiChallenge

<img src="https://team.stacklycode.com/challenges/db.png" />

DB - postgresql

## Auth

#### `/api/user/register` - post
```json
  {
    "username":"Blopa",
    "email":"Blopaemail",
    "password":"123456"
  }
```

**returns** - JWT token

#### `/api/user/login` - post
```json
  {
    "email":"Blopaemail",
    "password":"123456"
  }
```

**returns** - JWT token

## Skill

#### `/api/skills/register`- post
```json
{
  "skillname":  "Java",
  "created_at":  "2020-10-31"
}
```

**returns** - New Skill created

#### `/api/skills/{name}` - get
```
name {String} - Skill name
```

**returns** - Founded Skill

## Employee

#### `/api/user/skills/{name}` - post
```
HEADER - JWT token provided in register and login
```
```
name {String} - Skill name
```
**aclaration** - use this to add an skill to an employee

**returns** - String

#### `/api/user/getallusers` - get

**returns** - All Users
