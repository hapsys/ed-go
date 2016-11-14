var camera, scene, renderer, controls, camera, stars = {};

var proxy = new ProxyApi(false, false, '/systems/ajax/'); 

var init = function() {
	
	scene = new THREE.Scene();
	//camera = new THREE.PerspectiveCamera( 75, $('.menu-content').width()/$('.menu-content').height(), 0, 1000 );
	renderer = new THREE.WebGLRenderer();
	renderer.setClearColor(0x000000);
	renderer.setSize($('.menu-content').width(), $('.menu-content').height());
	renderer.sortObjects = false;
	renderer.autoClear = false;	
	
	
	camera = new THREE.PerspectiveCamera(45 
			, window.innerWidth / window.innerHeight , 0.1, 10000);
	
	
	controls = new THREE.TrackballControls( camera );

	controls.rotateSpeed = 10.0;
	controls.zoomSpeed = 1.2;
	controls.panSpeed = 0.8;

	controls.noZoom = false;
	controls.noPan = false;

	controls.staticMoving = true;
	controls.dynamicDampingFactor = 0.3;

	controls.keys = [ 65, 83, 68 ];

	controls.addEventListener( 'change', render );
	
	//material = new THREE.MeshBasicMaterial( { color: 0x777777 } );
	
	var axes = new THREE.AxisHelper(100);
	//scene.add(axes);	
	
	var sphereMaterial = new THREE.MeshBasicMaterial(
			{color: 0x999999, wireframe: false});
	/*
	var sphereGeometry = new THREE.SphereGeometry(10,20,20);
	var sphere = new THREE.Mesh(sphereGeometry,sphereMaterial);
	sphere.position.x = 0;
	sphere.position.y = 0;
	sphere.position.z = 0;
	scene.add(sphere);
	*/	
	//circle = new THREE.Mesh(geometry, material);
	
	camera.position.x = 50;
	camera.position.y = 50;
	camera.position.z = 50;
	camera.lookAt(scene.position);	
	//scene.add(circle);
	
	// Load Starts
	/*
	var geometry = new THREE.Geometry();
	var material = new THREE.PointsMaterial({
	      color: 0xeeeeee,
	      size: 1,
	      sizeAttenuation: false,
	});
	var particleSystem = new THREE.ParticleSystem(geometry, material);
	
	for (var k in stars) {
		var v = new THREE.Vector3();
		v.x = stars[k].x;
		v.y = stars[k].y;
		v.z = stars[k].z;
		geometry.vertices.push(v); 
	}
	scene.add(particleSystem);
	*/
	var geometry = new THREE.SphereGeometry(1,20,20);
	for (var k in stars) {
		var v = new THREE.Mesh(geometry,sphereMaterial);
		v.position.x = stars[k].x * 10;
		v.position.y = stars[k].y * 10;
		v.position.z = stars[k].z * 10;
		scene.add(v);
	}
	
	$('.menu-content').append(renderer.domElement);
	
	window.addEventListener( 'resize', onWindowResize, false );
	render();

}

function onWindowResize() {

	$('.menu-content').height(window.innerHeight - $('.header').height() - $('.footer').height() - 50);
	$('.menu-content').width(window.innerWidth  - 50);
	
	camera.aspect = window.innerWidth / window.innerHeight;
	camera.updateProjectionMatrix();

	//renderer.setSize( window.innerWidth, window.innerHeight );
	renderer.setSize($('.menu-content').width(), $('.menu-content').height());

	controls.handleResize();

	render();

}

function animate() {

	requestAnimationFrame( animate );
	controls.update();

}

function render() {

	renderer.render( scene, camera );
	//stats.update();

}

	
function load(callback) {
	
	var data = {
		x : 0,	
		y : 0,	
		z : 0,	
		scale : 50,	
	}
	
	proxy.makeCall('post', 'system-list/', null, null, data, function(response) {
		for (var i = 0; i < response.length; i++) {
			stars[response[i].system_id] = response[i]
		}
		callback();
	});
	
}


$(function() {
	load(function(){
		$('.menu-content').height(window.innerHeight - $('.header').height() - $('.footer').height() - 50);
		$('.menu-content').width(window.innerWidth  - 50);
		init();
		animate();
	});
});