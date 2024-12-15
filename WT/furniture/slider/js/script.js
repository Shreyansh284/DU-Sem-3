var swiper = new Swiper(".slide-content", {
    slidesPerView: 4,
    spaceBetween: 25,
    loop: true,
    centerSlide: 'true',
    fade: 'true',
    grabCursor: 'true',

    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },

    breakpoints:{
        375:{
            slidesPerView: 1,
        },
        280:{
            slidesPerView: 1,
        },
        768: {
            slidesPerView: 2, // Show two cards per view in tablet
        },
        986: {
            slidesPerView: 4, // Show four cards per view in desktop
        },
    },
  });
