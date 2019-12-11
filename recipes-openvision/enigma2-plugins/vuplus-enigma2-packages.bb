DESCRIPTION = "Vuplus Specific plugins"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c9e255efa454e0155c1fd758df7dcaf3"

DEPENDS = "python-native"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gitpkgv
 
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
BRANCH = "vuplus_experimental"

SRC_URI = "git://github.com/OpenVuPlus/dvbapp.git;protocol=http;branch=${BRANCH};tag=${SRCREV}"

S = "${WORKDIR}/git"

do_install() {
	install -d  ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/ManualFancontrol
	install -d  ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/LEDBrightnessSetup

	install -m 0644 ${S}/lib/python/Plugins/SystemPlugins/ManualFancontrol/*.py \
	${D}${libdir}/enigma2/python/Plugins/SystemPlugins/ManualFancontrol

	install -m 0644 ${S}/lib/python/Plugins/SystemPlugins/LEDBrightnessSetup/*.py \
	${D}${libdir}/enigma2/python/Plugins/SystemPlugins/LEDBrightnessSetup
	
	python -O -m compileall ${D}${libdir}/enigma2/python/Plugins/
}

FILES_enigma2-plugin-systemplugins-manualfancontrol = "${libdir}/enigma2/python/Plugins/SystemPlugins/ManualFancontrol"
FILES_enigma2-plugin-systemplugins-ledbrightnesssetup = "${libdir}/enigma2/python/Plugins/SystemPlugins/LEDBrightnessSetup"

PACKAGES = "\
	enigma2-plugin-systemplugins-manualfancontrol \
	enigma2-plugin-systemplugins-ledbrightnesssetup \
	"

PROVIDES="${PACKAGES}"
