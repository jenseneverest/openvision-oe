FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

MAINTAINER = "Open Vision Developers"

DEPENDS += "\
	${@bb.utils.contains("MACHINE_FEATURES", "rpi-vision", "libdvbcsa libnl userland ffmpeg e2-rpihddevice", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "libvugles2-${MACHINE} libgles-${MACHINE}", "", d)} \
	"

DEPENDS_append_sh4 += "\
	libmme-image libmme-host \
	"

RDEPENDS_${PN} += "\
	enigma2-plugin-extensions-pespeedup \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "glibc-gconv-cp1250", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "rpi-vision", "libdvbcsa e2-rpihddevice", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "libvugles2-${MACHINE} libgles-${MACHINE}", "", d)} \
	ntpdate \
	openvision-branding \
	"

RDEPENDS_${PN}_append_sh4 += "\
	libmme-host \
	alsa-utils-amixer-conf \
	"

RRECOMMENDS_${PN} = "\
	hotplug-e2-helper \
	glibc-gconv-utf-16 \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "ofgwrite", d)} \
	python-sendfile \
	virtual/enigma2-mediaservice \
	"

PYTHON_RDEPS += "\
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "python-imaging", d)} \
	python-process \
	python-pyusb \
	python-service-identity \
	"

DESCRIPTION_enigma2-plugin-font-wqy-microhei = "wqy-microhei font supports Chinese EPG"
PACKAGES =+ "enigma2-plugin-font-wqy-microhei"
FILES_enigma2-plugin-font-wqy-microhei = "${datadir}/fonts/wqy-microhei.ttc ${datadir}/fonts/fallback.font"
ALLOW_EMPTY_enigma2-plugin-font-wqy-microhei = "1"

inherit upx_compress

ENIGMA2_BRANCH ?= "develop"
PV = "develop+git${SRCPV}"
PKGV = "develop+git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/enigma2-openvision.git;branch=${ENIGMA2_BRANCH}"

EXTRA_OECONF_append += "\
	--with-boxbrand="${BOX_BRAND}" \
	--with-oever="${VISIONVERSION}" \
	${@bb.utils.contains("MACHINE_FEATURES", "bwlcd128", "--with-bwlcd128" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "bwlcd140", "--with-bwlcd140" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "bwlcd255", "--with-bwlcd255" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd220", "--with-colorlcd220" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd390", "--with-colorlcd390" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd400", "--with-colorlcd400" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd480", "--with-colorlcd480" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd720", "--with-colorlcd720" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd800", "--with-colorlcd800" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "hiaccel", "--with-libhiaccel" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "triaccel", "--with-libtriaccel" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "--with-libvugles2" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "osdanimation", "--with-osdanimation" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "olde2api", "--with-olde2api" , "", d)} \
	"

EXTRA_OECONF_sh4 = "\
	--enable-${MACHINE} --with-lcd \
	--with-libsdl=no --with-boxtype=${MACHINE} \
	--with-boxbrand="${BOX_BRAND}" \
	--with-oever="${VISIONVERSION}" \
	--enable-dependency-tracking \
	ac_cv_prog_c_openmp=-fopenmp \
	${@get_crashaddr(d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "textlcd", "--with-textlcd" , "", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "7segment 7seg", "--with-7segment" , "", d)} \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

# some plugins contain so's, their stripped symbols should not end up in the enigma2 package
FILES_${PN}-dbg += "\
	${libdir}/enigma2/python/*/.debug \
	${libdir}/enigma2/python/*/*.debug \
	${libdir}/enigma2/python/*/*/*/.debug \
	${libdir}/enigma2/python/*/*/*/*/.debug \
	${libdir}/enigma2/python/*/*/*/*/*/.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*/.debug \
	"

# Swig generated 200k enigma.py file has no purpose for end users
# Save some space by not installing sources (mytest.py must remain)
FILES_${PN}-src = "\
	${libdir}/enigma2/python/GlobalActions.py \
	${libdir}/enigma2/python/Navigation.py \
	${libdir}/enigma2/python/NavigationInstance.py \
	${libdir}/enigma2/python/RecordTimer.py \
	${libdir}/enigma2/python/ServiceReference.py \
	${libdir}/enigma2/python/SleepTimer.py \
	${libdir}/enigma2/python/e2reactor.py \
	${libdir}/enigma2/python/enigma.py \
	${libdir}/enigma2/python/keyids.py \
	${libdir}/enigma2/python/keymapparser.py \
	${libdir}/enigma2/python/skin.py \
	${libdir}/enigma2/python/timer.py \
	${libdir}/enigma2/python/BoxBrandingTest.py \
	${libdir}/enigma2/python/PowerTimer.py \
	${libdir}/enigma2/python/*/*.py \
	${libdir}/enigma2/python/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*.py \
	"

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True, extra_depends='')
    enigma2_podir = bb.data.expand('${datadir}/enigma2/po', d)
    do_split_packages(d, enigma2_podir, '^(\w+)/[a-zA-Z0-9_/]+.*$', 'enigma2-locale-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
}

CXXFLAGS_append_cube += " -std=c++11 -fPIC -fno-strict-aliasing "
CXXFLAGS_append_su980 += " -std=c++11 -fPIC -fno-strict-aliasing "
CXXFLAGS_append_sh4 += " -std=c++11 -fPIC -fno-strict-aliasing "
