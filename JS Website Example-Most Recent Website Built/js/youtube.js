function makeYoutubeVideo() {

    var tag = document.getElementById('ytAPI');
    console.log(tag);

    tag.src = "https://www.youtube.com/iframe_api";
    var firstScriptTag = document.getElementById('ytAPI')[0];
    console.log(firstScriptTag);
    firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

    //creates the youtube video
    var youtube;
    function onYouTubeIframeAPIReady() {
        youtube = new YT.Player('youtubePlayer', {
            height: '180',
            width: '245',
            videoId: optionData[i].link,
            events: {
                'onReady': onPlayerReady,
                'onStateChange': onPlayerStateChange
            }
        });
    }

    //plays the youtube video
    function onPlayerReady(event) {
        event.target.playVideo();
    }

    //used to determine when the video is done
    var done = false;
    function onPlayerStateChange(event) {
        if (event.data == YT.PlayerState.PLAYING && !done) {
            setTimeout(stopVideo, 6000);
            done = true;
        }
    }
    function stopVideo() {
        youtube.stopVideo();
    }
}