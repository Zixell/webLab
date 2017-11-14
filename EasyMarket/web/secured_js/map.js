ymaps.ready(init);
var map, myPlacemark, myPlacemark1, myPlacemark2;
function init() {
     map = new ymaps.Map("map", {
        center: [59.901, 30.318],
        zoom: 5
    });
    myPlacemark = new ymaps.Placemark([59.971211, 30.319972], {
        balloonContentBody: [
            '<address>',
            '<strong>SneakShop 1</strong>',
            '<br/>',
            'Санкт-Петербург, ул. Профессора Попова, 5к1',
            '<br/>',

            '</address>'
        ].join('')
    }, {
        preset: 'islands#redDotIcon'
    });

    myPlacemark1 = new ymaps.Placemark([59.935781, 30.325678], {
        balloonContentBody: [
            '<address>',
            '<strong>SneakShop 2</strong>',
            '<br/>',
            'Санкт-Петербург, Невский проспект, 28',
            '<br/>',

            '</address>'
        ].join('')
    }, {
        preset: 'islands#redDotIcon'
    });

    myPlacemark2 = new ymaps.Placemark([59.991278, 30.318693], {
        balloonContentBody: [
            '<address>',
            '<strong>SneakShop 3</strong>',
            '<br/>',
            'Санкт-Петербург, ул. Торжковская, 15',
            '<br/>',

            '</address>'
        ].join('')
    }, {
        preset: 'islands#redDotIcon'
    });

    myPlacemark.events.add('click', function (e) {
        document.getElementById("address_form").value = "Санкт-Петербург, ул. Профессора Попова, 5к1";
    });
    myPlacemark1.events.add('click', function (e) {
        document.getElementById("address_form").value = "Санкт-Петербург, Невский проспект, 28";
    });
    myPlacemark2.events.add('click', function (e) {
        document.getElementById("address_form").value = "Санкт-Петербург, ул. Торжковская, 15";
    });

    map.geoObjects.add(myPlacemark);
    map.geoObjects.add(myPlacemark1);
    map.geoObjects.add(myPlacemark2);


}

