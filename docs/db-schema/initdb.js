/**
 * init voter database strut
 */

function init() {
    //init collection 'user'
    db.user.drop();
    db.createCollection("user");
    db.user.insert({"username": "silencily", "email": "silencily@gmail.com",
        "password": "seven", "fullname": "silencily.seven", "smPhoto": "bytes",
        "lgPhoto": "bytes", "location": "Beijing", "joinedDate": new Date(),
        "voteCounter": {"votes": 2, "voted": 3, "starred": 4}})

    //init collection 'vote'
    db.vote.drop();
    db.createCollection("vote");
    db.vote.insert({"title":"hello world",})
}
init();

