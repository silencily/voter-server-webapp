/**
 * init voter database strut
 */

function init() {
    //init collection 'user'
    db.user.drop();
    db.createCollection("user");
    db.user.insert({"username": "silencily", "email": "silencily@gmail.com",
        "password": "seven", "fullname": "silencily.seven", "smPhoto": "bytes",
        "lgPhoto": "bytes", "location": "Beijing", "joinedDate": new Date(), "isEnabled": true,
        "voteCounter": {"votes": 2, "voted": 3, "starred": 4}});

    //init collection 'vote'
    db.vote.drop();
    db.createCollection("vote");
    db.vote.insert({"title": "hello world", "creator": db.user.findOne()._id.valueOf(),
        "createTime": new Date(), "voted": 2, "starred": 3, "isMulti": false, "isDel": false,
        "delTime": null, "lastUpdateTime": new Date(), "choices": [
            {"no": 1, "content": "first choice", "voted": 2, "ratio": 0.2},
            {"no": 2, "content": "second choice", "voted": 8, "ratio": 0.8}
        ]});

    //init collection 'notification'
    db.notification.drop();
    db.createCollection("notification");
    db.notification.insert({"to": db.user.findOne()._id.valueOf(), "type": 0, "notiTime": new Date(),
        "isReaded": false, "content": "hello world!", "isDel": false, "delTime": null})

    //init collection 'voted'
    db.voted.drop();
    db.createCollection("voted");
    db.voted.insert({"voter": db.user.findOne()._id.valueOf(),
        "vote": db.vote.findOne()._id.valueOf(), "voteTime": new Date()});

    //init collection 'starred'
    db.starred.drop();
    db.createCollection("starred");
    db.starred.insert({"voter": db.user.findOne()._id.valueOf(),
        "vote": db.vote.findOne()._id.valueOf(), "starredTime": new Date()});
}

init();

