db.createUser(
    {
        user: "fizz",
        pwd: "bazz",
        roles: [
            {
                role: "readWrite",
                db: "testdb"
            }
        ]
    }
)