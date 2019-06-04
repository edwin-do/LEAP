var config = {
        type: Phaser.AUTO,
        width: 800,
        height: 600,
        physics: {
            default: 'arcade',
            arcade: {
                gravity: { y: 200 }
            }
        },
        scene: {
            preload: preload,
            create: create
        }
    };

var game = new Phaser.Game(config);

function preload ()
{
    this.load.image('sky', 'images/blue-sky.jpg');
}

function create ()
{
	this.add.image(400,300,'sky');
}

function update ()
{
}