SUMMARY = "Broadcom DHD firmware"
LICENSE = "CLOSED"
require conf/license/license-close.inc

SRC_URI = "http://dreamboxupdate.com/download/opendreambox/2.6.0/${PN}/${PV}/all/6dceb8e2eeed94d6d19ca6fff2993802/${PN}_${PV}_all.tar.xz"

SRC_URI[md5sum] = "6dceb8e2eeed94d6d19ca6fff2993802"
SRC_URI[sha256sum] = "a09a769e5513a85ebbc11f29696b1cb8bf67555cd0b44339420704ecd8b9774b"

S = "${WORKDIR}/${PN}_${PV}_all"

PACKAGES = "${PN}"
FILES_${PN} += "${sysconfdir}/brcm ${nonarch_base_libdir}/firmware/brcm"

do_install() {
    install -d ${D}${sysconfdir}/brcm
    install -m 0644 ${S}${sysconfdir}/brcm/*.txt ${D}${sysconfdir}/brcm/

    install -d ${D}${nonarch_base_libdir}/firmware/brcm
    install -m 0644 ${S}${nonarch_base_libdir}/firmware/brcm/*.bin ${D}${nonarch_base_libdir}/firmware/brcm/
}
