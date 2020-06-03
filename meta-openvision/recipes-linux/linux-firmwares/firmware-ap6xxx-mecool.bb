SUMMARY = "Firmware files for ap6xxx mecool"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/firmware-ap6xxx-mecool.zip"

SRC_URI[md5sum] = "324c6e281dfc648a3532c73a62a71132"
SRC_URI[sha256sum] = "1aea21cc51d5eefc67119186b4a6f0c5da195ba4cadb28af48ce20a1f8bd10fd"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware/brcm"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/brcm
    install -m 0644 *.txt ${D}${nonarch_base_libdir}/firmware/brcm/
    install -m 0644 *.hcd ${D}${nonarch_base_libdir}/firmware/brcm/
    install -m 0644 *.bin ${D}${nonarch_base_libdir}/firmware/brcm/
}
