DESCRIPTION = "Azbox IPTV plugin"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/AZIPTV.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d  ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV
	
	install -m 0644 ${S}/*.pyo \
	${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV

	install -m 0755 ${S}/config \
	${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Picons/
        install -m 0644 ${S}/Picons/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Picons/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Ico/
        install -m 0644 ${S}/Ico/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Ico/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Lists/
        install -m 0755 ${S}/Lists/* ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Lists/
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/AzIPTV"

PACKAGES = "enigma2-plugin-extensions-aziptv"

PROVIDES="${PACKAGES}"
