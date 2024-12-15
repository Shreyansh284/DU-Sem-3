document.addEventListener("DOMContentLoaded", function() {
    // Function to check if an element is in the viewport at 30%
    function isInViewport(element) {
      var bounding = element.getBoundingClientRect();
      var viewportHeight = window.innerHeight || document.documentElement.clientHeight;
      var viewportWidth = window.innerWidth || document.documentElement.clientWidth;
      var threshold = 0.9; // 30% threshold
  
      return (
        bounding.top + bounding.height * threshold >= 0 &&
        bounding.left + bounding.width * threshold >= 0 &&
        bounding.bottom - bounding.height * threshold <= viewportHeight &&
        bounding.right - bounding.width * threshold <= viewportWidth
      );
    }
  
    // Set up a variable to keep track of animated elements
    var animatedElements = [];
  
    // Function to handle scroll event
    function handleScroll() {
      var elementsToAnimate = document.querySelectorAll('.mainHeader');
      elementsToAnimate.forEach(function(element) {
        if (isInViewport(element) && !animatedElements.includes(element)) {
          element.classList.add('animate__fadeInDown');
          animatedElements.push(element); // Add element to the list of animated elements
        }
      });
      var elementsToAnimate = document.querySelectorAll('.productScroll');
      elementsToAnimate.forEach(function(element) {
        if (isInViewport(element) && !animatedElements.includes(element)) {
          element.classList.add('animate__fadeInUp');
          animatedElements.push(element); // Add element to the list of animated elements
        }
      });
      var elementsToAnimate = document.querySelectorAll('.teamscroll');
      elementsToAnimate.forEach(function(element) {
        if (isInViewport(element) && !animatedElements.includes(element)) {
          element.classList.add('animate__zoomIn');
          animatedElements.push(element); // Add element to the list of animated elements
        }
      });
      var elementsToAnimate = document.querySelectorAll('.SideContant');
      elementsToAnimate.forEach(function(element) {
        if (isInViewport(element) && !animatedElements.includes(element)) {
          element.classList.add('animate__fadeInRight');
          animatedElements.push(element); // Add element to the list of animated elements
        }
      });
      var elementsToAnimate = document.querySelectorAll('.left');
      elementsToAnimate.forEach(function(element) {
        if (isInViewport(element) && !animatedElements.includes(element)) {
          element.classList.add('animate__fadeInLeft');
          animatedElements.push(element); // Add element to the list of animated elements
        }
      });
   
    }
  
    // Initial check on page load
    handleScroll();
  
    // Event listener for scroll event
    window.addEventListener('scroll', handleScroll);
  });
  