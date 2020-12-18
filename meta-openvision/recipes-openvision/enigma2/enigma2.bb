SUMMARY = "GUI frontend for Open Source Linux based receivers"
DESCRIPTION = "Enigma2 is a framebuffer based frontend for DVB functions on Linux settop boxes"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "\
	avahi \
	freetype \
	gettext-native \
	jpeg \
	libdreamdvd libdvbsi++ libfribidi libmad libpng libsigc++-2.0 giflib libxml2 \
	openssl libudfread \
	${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "python3-pillow", "python-imaging", d)} ${PYTHONNAMEONLY}-twisted python-wifi \
	${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "python3-six", "python-six-native", d)} \
	swig-native \
	tuxtxt-enigma2 \
	"

RDEPENDS_${PN} = "\
	alsa-conf \
	enigma2-data-iso-639-3 \
	enigma2-fonts \
	enigma2-plugin-extensions-pespeedup \
	enigma2-timezones \
	ethtool \
	glibc-gconv-iso8859-15 \
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "", "glibc-gconv-cp1250", d)} \
	ntpdate \
	openvision-branding \
	${PYTHON_RDEPS} \
	${@bb.utils.contains("MACHINE_FEATURES", "emmc", "bzip2 rsync", "", d)} \
	"

RRECOMMENDS_${PN} = "\
	hotplug-e2-helper \
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "", "ofgwrite", d)} \
	${PYTHONNAMEONLY}-sendfile \
	virtual/enigma2-mediaservice \
	"

PYTHONEXACTVERSION_CHECK = "${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "python3-image python3-pillow", "python-image python-imaging", d)}"

PYTHON_RDEPS = "\
	${PYTHONNAMEONLY}-codecs \
	${PYTHONNAMEONLY}-core \
	${PYTHONNAMEONLY}-crypt \
	${PYTHONNAMEONLY}-fcntl \
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "", "${PYTHONEXACTVERSION_CHECK}", d)} \
	${PYTHONNAMEONLY}-mmap \
	${PYTHONNAMEONLY}-netclient \
	${PYTHONNAMEONLY}-netifaces \
	${PYTHONNAMEONLY}-netserver \
	${PYTHONNAMEONLY}-numbers \
	${PYTHONNAMEONLY}-pickle \
	python-process \
	${PYTHONNAMEONLY}-pyusb \
	${PYTHONNAMEONLY}-service-identity \
	${PYTHONNAMEONLY}-shell \
	${PYTHONNAMEONLY}-six \
	${PYTHONNAMEONLY}-threading \
	${PYTHONNAMEONLY}-twisted-core \
	${PYTHONNAMEONLY}-twisted-web \
	${PYTHONNAMEONLY}-xml \
	${PYTHONNAMEONLY}-zopeinterface \
	${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "", " \
	python-lang \
	python-re \
	python-zlib", d)} \
	"

# DVD and iso playback is integrated, we need the libraries
RDEPENDS_${PN} += "libdreamdvd libudfread"
RRECOMMENDS_${PN} += "libdvdcss"

# We depend on the font which we use for TXT subtitles (defined in skin_subtitles.xml)
RDEPENDS_${PN} += "font-valis-enigma"

RDEPENDS_${PN} += "${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbc", "virtual/blindscan-dvbc" , "", d)}"

DEMUXTOOL ?= "replex"

DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "${PYTHONNAMEONLY}-twisted-web"
DESCRIPTION_append_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools python-wifi"
DESCRIPTION_append_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"
# Note that these tools lack recipes
RDEPENDS_enigma2-plugin-extensions-dvdburn = "dvd+rw-tools dvdauthor mjpegtools cdrkit ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "python3-pillow", "python-imaging", d)} ${DEMUXTOOL} kernel-module-pktcdvd"
RDEPENDS_enigma2-plugin-extensions-dvdplayer = "kernel-module-udf"
RDEPENDS_enigma2-plugin-systemplugins-hotplug = "hotplug-e2-helper"

DESCRIPTION_enigma2-plugin-fonts-wqy-microhei = "wqy-microhei font supports Chinese EPG"
PACKAGES += "enigma2-plugin-fonts-wqy-microhei"
FILES_enigma2-plugin-fonts-wqy-microhei = "${datadir}/fonts/wqy-microhei.ttc ${datadir}/fonts/fallback.font"
ALLOW_EMPTY_enigma2-plugin-fonts-wqy-microhei = "1"

# Fake package that doesn't actually get built, but allows OE to detect
# the RDEPENDS for the plugins above, preventing [build-deps] warnings.
RDEPENDS_${PN}-build-dependencies = "\
	aio-grab \
	dvd+rw-tools dvdauthor mjpegtools cdrkit ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "python3-pillow", "python-imaging", d)} ${DEMUXTOOL} \
	${PYTHONNAMEONLY}-twisted-web \
	wpa-supplicant wireless-tools python-wifi \
	"

inherit gitpkgv ${PYTHONNAMEONLY}native upx_compress autotools pkgconfig rm_python_pyc compile_python_pyo

ENIGMA2_BRANCH = "develop"
PV = "develop+git${SRCPV}"
PKGV = "develop+git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/enigma2-openvision.git;branch=${ENIGMA2_BRANCH}"

SRC_URI_append_dm800 = " file://get-rid-of-HAVE-OLDE2-API-condition.patch"

LDFLAGS_prepend = " -lxml2 "

S = "${WORKDIR}/git"

PACKAGES += "${PN}-meta ${PN}-build-dependencies enigma2-fonts"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PKGV_enigma2-fonts = "2020.10.17"

def get_crashaddr(d):
    if d.getVar('CRASHADDR', True):
        return '--with-crashlogemail="${CRASHADDR}"'
    else:
        return ''

EXTRA_OECONF = "\
	--with-libsdl=no --with-boxtype=${MACHINE} \
	--enable-dependency-tracking \
	ac_cv_prog_c_openmp=-fopenmp \
	${@get_crashaddr(d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "textlcd", "--with-textlcd" , "", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "7segment 7seg", "--with-7segment" , "", d)} \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	--with-boxbrand=${BOX_BRAND} \
	--with-stbplatform=${STB_PLATFORM} \
	--with-oever=${VISIONVERSION} \
	${@bb.utils.contains("MACHINE_FEATURES", "bwlcd128", "--with-bwlcd128" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "bwlcd140", "--with-bwlcd140" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "bwlcd255", "--with-bwlcd255" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd220", "--with-colorlcd220" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd390", "--with-colorlcd390" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd400", "--with-colorlcd400" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd480", "--with-colorlcd480" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd720", "--with-colorlcd720" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "colorlcd800", "--with-colorlcd800" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "nolcd", "--with-nolcd" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "hiaccel", "--with-libhiaccel" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "triaccel", "--with-libtriaccel" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "--with-libvugles2" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "osdanimation", "--with-osdanimation" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "olde2api", "--with-olde2api" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "fcc", "--with-fcc" , "", d)} \
	"

# pass the enigma branch to automake
EXTRA_OEMAKE = "\
	ENIGMA2_BRANCH=${ENIGMA2_BRANCH} \
	"

FILES_enigma2-fonts = "${datadir}/fonts"
FILES_${PN} += "${datadir}/keymaps ${bindir} ${libdir}"
FILES_${PN}-meta = "${datadir}/meta"

# some plugins contain so's, their stripped symbols should not end up in the enigma2 package
FILES_${PN}-dbg += "\
	${libdir}/enigma2/python/*.debug \
	${libdir}/enigma2/python/*/*.debug \
	${libdir}/enigma2/python/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*/*.debug \
	"

# Swig generated 200k enigma.py file has no purpose for end users
# Save some space by not installing sources (mytest.py must remain)
FILES_${PN}-src = "\
	${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "", " \
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
	${libdir}/enigma2/python/*/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*/*.py", d)} \
	"

do_install_append() {
	install -d ${D}${datadir}/keymaps
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "multilib", "1", "0", d)}" = "1" ]; then
		install -d ${D}${prefix}/lib
		ln -s ${libdir}/enigma2 ${D}${prefix}/lib/enigma2
		ln -s ${libdir}/${PYTHONPATHVERSION} ${D}${prefix}/lib/${PYTHONPATHVERSION}
	fi
	install -m 0644 ${S}/data/rc_models/${RCNAME}.png ${D}${datadir}/enigma2/rc_models/
	install -m 0644 ${S}/data/rc_models/${RCNAME}.xml ${D}${datadir}/enigma2/rc_models/
	if [ "${MACHINE}" = "azboxhd" ]; then
		install -m 0644 ${S}/data/rc_models/azboxelite.png ${D}${datadir}/enigma2/rc_models/
		install -m 0644 ${S}/data/rc_models/azboxelite.xml ${D}${datadir}/enigma2/rc_models/
	fi
}

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True, extra_depends='')
    enigma2_podir = bb.data.expand('${datadir}/enigma2/po', d)
    do_split_packages(d, enigma2_podir, '^(\w+)/[a-zA-Z0-9_/]+.*$', 'enigma2-locale-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
}

CXXFLAGS_append_cube = " -std=c++11 -fPIC -fno-strict-aliasing"
CXXFLAGS_append_su980 = " -std=c++11 -fPIC -fno-strict-aliasing"
