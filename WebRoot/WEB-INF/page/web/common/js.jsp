<!-- Waypoints -->
<script src="/web/js/jquery.waypoints.min.js"></script>
<!-- Superfish -->
<script src="/web/js/superfish.js"></script>
<!-- Flexslider -->
<script src="/web/js/jquery.flexslider-min.js"></script>

<!-- Main JS (Do not remove) -->
<script src="/web/js/main.js"></script>
<script src="/web/js/scrollreveal.min.js"></script>
<script>
		ScrollReveal({ distance: '80px' });
		var option = {
			duration: 1000,
			viewFactor: 1,
			origin: "left",
			easing: 'cubic-bezier(.25,.1,.25,1)',
		}

		ScrollReveal().reveal('.headline-anime', option)
		var option2 = {
			duration: 800,
			viewFactor: 0.7,
			origin: "top",
			easing: 'cubic-bezier(.25,.1,.25,1)',
		}
		ScrollReveal().reveal('.banner-anime', option2);
	</script>