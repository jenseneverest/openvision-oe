DESCRIPTION = "Linux Bluetooth Stack Userland v5 configurations"
require conf/license/license-gplv2.inc

inherit bluetooth

DEPENDS = "glib-2.0 bluez5"

SRC_URI = "file://main.conf file://uart.conf"

S = "${WORKDIR}"

do_install () {
    install -m 0755 -d ${D}${sysconfdir}/bluetooth/
    install -m 0644 ${S}/main.conf ${D}${sysconfdir}/bluetooth/main.conf
    install -m 0644 ${S}/uart.conf ${D}${sysconfdir}/bluetooth/uart.conf
    if [ "${MACHINE}" = "osnino" -o "${MACHINE}" = "osninoplus" -o "${MACHINE}" = "osninopro" -o "${MACHINE}" = "spycat" -o "${MACHINE}" = "spycatmini" -o "${MACHINE}" = "spycatminiplus" -o "${MACHINE}" = "osmini" -o "${MACHINE}" = "osminiplus" ]; then
        echo "ttyS2 rtk_h5" >> ${D}${sysconfdir}/bluetooth/uart.conf
    elif [ "${MACHINE}" = "osmega" ]; then
        echo "ttyS1 rtk_h5" >> ${D}${sysconfdir}/bluetooth/uart.conf
    else
        echo "" >> ${D}${sysconfdir}/bluetooth/uart.conf
    fi
}
